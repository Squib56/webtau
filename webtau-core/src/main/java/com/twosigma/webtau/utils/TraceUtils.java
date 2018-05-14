/*
 * Copyright 2018 TWO SIGMA OPEN SOURCE, LLC
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

package com.twosigma.webtau.utils;

import com.twosigma.webtau.data.render.DataRenderers;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TraceUtils {
    private TraceUtils() {
    }

    public static String renderValueAndType(Object v) {
        return DataRenderers.render(v) + " " + renderType(v);
    }

    public static String renderType(Object v) {
        return "<" + (v == null ? "null" : v.getClass().getCanonicalName()) + ">";
    }

    public static String stackTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);

        return stringWriter.toString();
    }
}