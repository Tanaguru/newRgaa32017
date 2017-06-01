/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015 Tanaguru.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rules.rgaa32017;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractPageRuleMarkupImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.ElementChecker;
import org.tanaguru.rules.elementchecker.attribute.AttributePresenceChecker;
import org.tanaguru.rules.elementchecker.attribute.IdUnicityChecker;
import org.tanaguru.rules.elementchecker.element.ElementPresenceChecker;
import org.tanaguru.rules.elementchecker.text.TextEmptinessChecker;
import org.tanaguru.rules.elementselector.SimpleElementSelector;
import org.tanaguru.rules.elementselector.builder.CssLikeSelectorBuilder;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABELLEDBY_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ARIA_LABEL_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.FOR_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.ID_ATTR;
import static org.tanaguru.rules.keystore.AttributeStore.TITLE_ATTR;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.CssLikeQueryStore.INPUT_ELEMENT_INSIDE_FORM_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.HtmlElementStore.FORM_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.INPUT_ELEMENT;
import static org.tanaguru.rules.keystore.HtmlElementStore.LABEL_ELEMENT;
import static org.tanaguru.rules.keystore.RemarkMessageStore.FOR_MISSING_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ID_MISSING_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.ID_NOT_UNIQUE_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_INPUT_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.INVALID_LABEL_MSG;
import org.tanaguru.rules.textbuilder.TextAttributeOfElementBuilder;

/**
 * Implementation of the rule 11.1.2 of the referential Rgaa 3-2017.
 * <br/>
 * For more details about the implementation, refer to <a
 * href="http://tanaguru-rules-rgaa3.readthedocs.org/en/latest/Rule-11-1-2">the rule 11.1.2
 * design page.</a>
 *
 * @see <a
 * href="http://references.modernisation.gouv.fr/referentiel-technique-0#test-11-1-2">
 * 11.1.2 rule specification</a>
 *
 */
public class Rgaa32017Rule110102 extends AbstractPageRuleMarkupImplementation {

    private SimpleElementSelector selector;
    private final ElementHandler<Element> labelElementHandler = new ElementHandlerImpl();
    private final ElementHandler<Element> inputElementHandler = new ElementHandlerImpl();
    private final Map<Element, ElementHandler<Element>> labelFormMap = new HashMap<>();
    private final Map<Element, ElementHandler<Element>> inputFormMap = new HashMap<>();

    /**
     * Default constructor
     */
    public Rgaa32017Rule110102() {
        super();
    }

    @Override
    protected void select(SSPHandler sspHandler) {
        selector = new SimpleElementSelector(LABEL_ELEMENT);
        selector.selectElements(
                sspHandler,
                labelElementHandler);
        putLabelElementHandlerIntoTheMap();
        selector.setCssLikeQuery(INPUT_ELEMENT_INSIDE_FORM_CSS_LIKE_QUERY);
        selector.selectElements(
                sspHandler,
                inputElementHandler);
        putInputElementHandlerIntoTheMap();
    }

    @Override
    public int getSelectionSize() {
        return inputElementHandler.get().size();
    }

    @Override
    protected void check(
            SSPHandler sspHandler,
            TestSolutionHandler testSolutionHandler) {

        /* If the page has no input form element, the test is not applicable */
        if (inputFormMap.entrySet().isEmpty()) {
            testSolutionHandler.addTestSolution(TestSolution.NOT_APPLICABLE);
            return;
        }

        for (Map.Entry<Element, ElementHandler<Element>> entry : inputFormMap.entrySet()) {
            /* The attribute Presence Checker */
            ElementChecker attributePresenceChecker
                    = new AttributePresenceChecker(
                            ID_ATTR,
                            new ImmutablePair(TestSolution.PASSED,""),
                            new ImmutablePair(TestSolution.FAILED,ID_MISSING_MSG));
            
            attributePresenceChecker.check(sspHandler, entry.getValue(), testSolutionHandler);

            /* The attribute Emptiness Checker. Keep default value i.e failed 
             when attribute is empty
             */
            ElementChecker attributeEmptinessChecker
                    = new TextEmptinessChecker(
                            new TextAttributeOfElementBuilder(ID_ATTR),
                            ID_MISSING_MSG,
                            null);
            attributeEmptinessChecker.check(sspHandler, entry.getValue(), testSolutionHandler);

            /* The id unicityChecker */
            ElementChecker idUnicityChecker = new IdUnicityChecker(ID_NOT_UNIQUE_MSG);
            idUnicityChecker.check(sspHandler, entry.getValue(), testSolutionHandler);
        }

        for (Map.Entry<Element, ElementHandler<Element>> entry : labelFormMap.entrySet()) {
            /* The attribute Presence Checker */
            ElementChecker attributePresenceChecker
                    = new AttributePresenceChecker(
                            FOR_ATTR,
                            new ImmutablePair(TestSolution.PASSED, ""),
                            new ImmutablePair(TestSolution.FAILED, FOR_MISSING_MSG));
            
            attributePresenceChecker.check(sspHandler, entry.getValue(), testSolutionHandler);

            /* The attribute Emptiness Checker. Keep default value i.e failed 
             when attribute is empty
             */
            ElementChecker attributeEmptinessChecker
                    = new TextEmptinessChecker(
                            new TextAttributeOfElementBuilder(FOR_ATTR),
                            FOR_MISSING_MSG,
                            null);
            attributeEmptinessChecker.check(sspHandler, entry.getValue(), testSolutionHandler);
        }

        for (Map.Entry<Element, ElementHandler<Element>> entry : inputFormMap.entrySet()) {
            ElementHandler<Element> inputOnError = new ElementHandlerImpl();
            /* Check if each input id attribute is linked to a for attribute*/
            for (Element el : entry.getValue().get()) {
                String id = el.id();
                if (StringUtils.isNotBlank(id)) {
                    ElementHandler<Element> linkedLabelToInputHandler = new ElementHandlerImpl();
                    if (entry.getKey().select(LABEL_ELEMENT + " "
                            + CssLikeSelectorBuilder.buildSelectorFromElementsAndAttributeValue(INPUT_ELEMENT, ID_ATTR, id)).isEmpty()) {
                        linkedLabelToInputHandler
                                .addAll(entry.getKey()
                                        .select(CssLikeSelectorBuilder
                                                .buildSelectorFromElementsAndAttributeValue(LABEL_ELEMENT, FOR_ATTR, id)));
                        if (linkedLabelToInputHandler.isEmpty()) {
                            inputOnError.add(el);
                        }
                    }
                }
            }
            ElementChecker elementPresenceChecker = new ElementPresenceChecker(
                            new ImmutablePair(TestSolution.FAILED,INVALID_INPUT_MSG),
                            new ImmutablePair(TestSolution.PASSED,""));
            
            elementPresenceChecker.check(sspHandler, inputOnError, testSolutionHandler);
        }

        for (Map.Entry<Element, ElementHandler<Element>> entry : labelFormMap.entrySet()) {
            ElementHandler<Element> labelOnError = new ElementHandlerImpl();
            /* Check if each label for attribute is associated to an input id attribute*/
            for (Element el : entry.getValue().get()) {
                String id = el.attr(FOR_ATTR);
                if (StringUtils.isNotBlank(id)) {
                    ElementHandler<Element> linkedLabelToInputHandler = new ElementHandlerImpl();
                    linkedLabelToInputHandler
                            .addAll(entry.getKey()
                                    .select(CssLikeSelectorBuilder
                                            .buildSelectorFromId(id)));
                    if (linkedLabelToInputHandler.isEmpty()) {
                        labelOnError.add(el);
                    }
                }
            }
            ElementChecker elementPresenceChecker = new ElementPresenceChecker(
                            new ImmutablePair(TestSolution.FAILED,INVALID_LABEL_MSG),
                            new ImmutablePair(TestSolution.PASSED,""));
            
            elementPresenceChecker.check(sspHandler, labelOnError, testSolutionHandler);
        }
    }

    /**
     * This method linked each input on a page to its form in a map.
     */
    private void putInputElementHandlerIntoTheMap() {
        for (Element el : inputElementHandler.get()) {
            if (!el.hasAttr(TITLE_ATTR)
                    && !el.hasAttr(ARIA_LABEL_ATTR)
                    && !el.hasAttr(ARIA_LABELLEDBY_ATTR)) {
                Element tmpElement = el.parent();
                while (StringUtils.isNotBlank(tmpElement.tagName())) {
                    if (tmpElement.tagName().equals(FORM_ELEMENT)) {
                        if (inputFormMap.containsKey(tmpElement)) {
                            inputFormMap.get(tmpElement).add(el);
                        } else {
                            ElementHandler<Element> inputElement = new ElementHandlerImpl();
                            inputElement.add(el);
                            inputFormMap.put(tmpElement, inputElement);
                        }
                        break;
                    }
                    tmpElement = tmpElement.parent();
                }
            }
        }
    }

    /**
     * This method linked each label which have an input child on a page to its
     * form in a map.
     */
    private void putLabelElementHandlerIntoTheMap() {
        for (Element el : labelElementHandler.get()) {
            Element tmpElement = el.parent();
            
            while (tmpElement!=null && StringUtils.isNotBlank(tmpElement.tagName())) {
                if (tmpElement.tagName().equals(FORM_ELEMENT)) {
                    if (labelFormMap.containsKey(tmpElement)) {
                        Elements els = el.select(FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY);
                        if (!els.isEmpty()) {
                            labelFormMap.get(tmpElement).add(el);
                        }
                    } else {
                        Elements els = el.select(FORM_ELEMENT_WITH_ID_CSS_LIKE_QUERY);
                        if (!els.isEmpty()) {
                            ElementHandler<Element> labelElement = new ElementHandlerImpl();
                            labelElement.add(el);
                            labelFormMap.put(tmpElement, labelElement);
                        }
                    }
                    break;
                }
                tmpElement = tmpElement.parent();
            }
        }
    }
}
