/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.java.function.time.supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author Soby Chacko
 * @author Artem Bilan
 */
public class SimpleTimeSupplierTests extends TimeSupplierApplicationTests {

	@Test
	public void testTimeSupplier() {
		final String time = timeSupplier.get();
		SimpleDateFormat dateFormat = new SimpleDateFormat(new TimeProperties().getDateFormat());
		assertThatCode(() -> {
			Date date = dateFormat.parse(time);
			assertThat(date).isNotNull();
		}).doesNotThrowAnyException();
	}

}
