/*
 * Copyright 2020 webtau maintainers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package scenarios

import static org.testingisdocumenting.webtau.WebTauGroovyDsl.*
import static pages.Pages.*

scenario('summary view') {
    report.openGroovyStandaloneReport('rest/springboot/customerCrudSeparatedMissingMethod-webtau-report.html')
    browser.doc.capture('report-summary')
}

scenario('customer update test summary') {
    report.selectTest('customer update')
    browser.doc.capture('report-test-summary')
}

scenario('customer update http calls') {
    report.openGroovyStandaloneReport('rest/springboot/customerCrudSeparated-webtau-report.html')
    report.selectTest('customer update')

    report.selectHttpCalls()
    report.expandHttpCall(2)

    browser.doc.withAnnotations(
            browser.doc.highlight(report.fullScreenIcon),
            browser.doc.highlight(report.collapsedHeader))
            .capture('report-crud-separated-http-calls')
}