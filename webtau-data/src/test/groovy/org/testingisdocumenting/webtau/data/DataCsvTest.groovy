/*
 * Copyright 2021 webtau maintainers
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

package org.testingisdocumenting.webtau.data

import org.junit.Test
import org.testingisdocumenting.webtau.data.DataCsv

class DataCsvTest {
    @Test
    void "parse csv as table data"() {
        def table = new DataCsv().table('src/test/resources/test.csv')
        table.should == ['id' | 'absolute' | 'number' | 'comment'] {
                        _______________________________________________
                        'id1' | 'yes'      | '12'     | 'what can you say'
                        'id2' | 'no'       | '24'     | 'fourth'
        }
    }

    @Test
    void "parse csv as table data with auto conversion of types"() {
        def table = new DataCsv().tableAutoConverted('src/test/resources/test.csv')
        table.should == ['id' | 'absolute' | 'number' | 'comment'] {
                        _______________________________________________
                        'id1' | 'yes'      | 12       | 'what can you say'
                        'id2' | 'no'       | 24       | 'fourth' }

        (table.row(0).get('number') instanceof Number).should == true
        (table.row(1).get('number') instanceof Number).should == true
    }

    @Test
    void "parse empty csv as table data"() {
        def table = new DataCsv().table('src/test/resources/empty.csv')
        table.size().should == 0
        table.header.size().should == 0
    }
}
