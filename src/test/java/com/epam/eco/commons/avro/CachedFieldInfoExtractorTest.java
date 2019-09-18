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
package com.epam.eco.commons.avro;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.eco.commons.avro.data.TestPerson;

/**
 * @author Andrei_Tytsik
 */
public class CachedFieldInfoExtractorTest {

    @Test
    public void testInfosAreCached() throws Exception {
        List<FieldInfo> infos1 = CachedFieldExtractor.fromSchema(TestPerson.SCHEMA$);

        Assert.assertNotNull(infos1);

        List<FieldInfo> infos2 = CachedFieldExtractor.fromSchema(TestPerson.SCHEMA$);

        Assert.assertNotNull(infos2);
        Assert.assertTrue(infos1 == infos2);
    }

}
