/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2017  Tanaguru.org
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

import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.rules.rgaa32017.test.Rgaa32017RuleImplementationTestCase;
import org.tanaguru.rules.keystore.HtmlElementStore;
import org.tanaguru.rules.keystore.RemarkMessageStore;

/**
 * Unit test class for the implementation of the rule 10.13.1 of the referential Rgaa 3-2017.
 *
 * @author jkowalczyk
 */
public class Rgaa32017Rule101301Test extends Rgaa32017RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32017Rule101301Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.tanaguru.rules.rgaa32017.Rgaa32017Rule101301");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-01");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-02");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-03");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-04");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-05");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-06");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-07");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-08");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-09");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-10");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-11");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-12");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-13");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-14");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-15");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-16");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-17");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-18");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-19");
        addWebResource("Rgaa32017.Test.10.13.1-3NMI-20");
        addWebResource("Rgaa32017.Test.10.13.1-4NA-01");
        addWebResource("Rgaa32017.Test.10.13.1-4NA-02");
        addWebResource("Rgaa32017.Test.10.13.1-4NA-03");
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);

        //----------------------------------------------------------------------
        //------------------------------3NMI-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-05");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-06");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-07");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-08");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-09");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-10");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-11");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-12------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-12");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-13------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-13");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-14------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-14");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-15------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-15");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-16------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-16");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-17------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-17");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-18------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-18");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-19------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-19");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);


        //----------------------------------------------------------------------
        //------------------------------3NMI-20------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32017.Test.10.13.1-3NMI-20");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.HIDDEN_TEXT_DETECTED_MSG,
                HtmlElementStore.SPAN_ELEMENT,
                1);

        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.13.1-4NA-01"));


        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.13.1-4NA-02"));


        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32017.Test.10.13.1-4NA-03"));

    }

}
