/*
 *
 * Copyright 2016 EUROPEAN COMMISSION
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/community/eupl/og_page/eupl
 *
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 *
 */

package eu.europa.ec.grow.espd.xml.request.selection

import eu.europa.ec.grow.espd.domain.enums.criteria.SelectionCriterion
import eu.europa.ec.grow.espd.domain.EconomicFinancialStandingCriterion
import eu.europa.ec.grow.espd.domain.EspdDocument
import eu.europa.ec.grow.espd.xml.base.AbstractSelectionCriteriaFixture
/**
 * Created by ratoico on 12/9/15 at 1:48 PM.
 */
class FinancialRatioRequestTest extends AbstractSelectionCriteriaFixture {

    def "11. should contain the 'Financial ratio' criterion"() {
        given:
        def espd = new EspdDocument(financialRatio: new EconomicFinancialStandingCriterion(exists: true))

        when:
        def request = generateRequestXml(espd)
        def idx = getRequestCriterionIndex(SelectionCriterion.FINANCIAL_RATIO)

        then: "CriterionID element"
        checkCriterionId(request, idx, "e4d37adc-08cd-4f4d-a8d8-32b62b0a1f46")

        then: "CriterionTypeCode element"
        checkCriterionTypeCode(request, idx, "CRITERION.SELECTION.ECONOMIC_FINANCIAL_STANDING.FINANCIAL_RATIO")

        then: "CriterionName element"
        request.Criterion[idx].Name.text() == "Financial ratio"

        then: "CriterionDescription element"
        request.Criterion[idx].Description.text() == "Concerning the financial ratios  specified in the relevant notice, the procurement documents or the ESPD, the economic operator declares that the actual values for the required ratios are as follows:"

        then: "CriterionLegislationReference element"
        checkLegislationReference(request, idx, "58(3)")

        then: "check all the sub groups"
        request.Criterion[idx].RequirementGroup.size() == 2

        then: "main sub group"
        def g1 = request.Criterion[idx].RequirementGroup[0]
        checkDescriptionRatioGroup1(g1)

        then: "check description ratio subgroups"

        then: "info available electronically sub group"
        def g2 = request.Criterion[idx].RequirementGroup[1]
        checkInfoAvailableElectronicallyRequirementGroup(g2)
    }

}