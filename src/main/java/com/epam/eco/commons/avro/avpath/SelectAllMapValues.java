/*
 * Copyright 2019 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.epam.eco.commons.avro.avpath;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Andrei_Tytsik
 */
public class SelectAllMapValues implements Expression<Map<?, ?>> {

    @Override
    public boolean accepts(Object object) {
        return object instanceof Map;
    }

    @Override
    public List<EvaluationResult> eval(Map<?, ?> map) {
        if (map == null) {
            return Collections.emptyList();
        }

        return map.keySet().stream().
                map(key -> SelectMapValueResult.with(
                        map,
                        key,
                        map.get(key))).
                collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Map[*]";
    }

}
