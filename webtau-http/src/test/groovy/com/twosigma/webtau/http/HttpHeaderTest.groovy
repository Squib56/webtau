/*
 * Copyright 2019 TWO SIGMA OPEN SOURCE, LLC
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

package com.twosigma.webtau.http

import org.junit.Test

class HttpHeaderTest {
    @Test
    void "renders header as key = value"() {
        def header = new HttpHeader(['Content-Type': 'application/json', 'Authorization': 'Bearer'])
        header.toString().should == 'Content-Type: application/json\n' +
            'Authorization: Bearer'
    }

    @Test
    void "should redact authorization and cookies header values"() {
        def header = new HttpHeader([
                'Content-Type': 'application/json',
                'Authorization': 'Bearer',
                'Custom': 'Value',
                'Cookie': 'sweet',
                'Set-Cookie': 'will be sweet'])

        header.redactSecrets().toMap().should == [  'key'         | 'value'           ] {
                                                 ______________________________________
                                                   'Content-Type' | 'application/json'
                                                  'Authorization' | '................'
                                                         'Custom' | 'Value'
                                                         'Cookie' | '................'
                                                     'Set-Cookie' | '................' }
    }
}