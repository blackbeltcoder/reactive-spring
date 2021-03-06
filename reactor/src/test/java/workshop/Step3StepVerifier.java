/*
 * Copyright 2017 the original author or authors.
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
package workshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Testing reactive sequences.
 *
 * @author Mark Paluch
 */
public class Step3StepVerifier {

	@Test
	public void verifyMonoEmission() {

		Mono<String> mono = Mono.just("Hello, World").doOnSuccess(System.out::println);

		// Use StepVerifier to verify Mono emission
	}

	@Test
	public void verifyFluxEmission() {

		Flux<String> flux = Flux.just("Hello", "World").doOnNext(System.out::println);

		// Use StepVerifier to verify Flux emission
	}

	@Test
	public void verifyInfiniteStreamEmission() {

		Flux<Double> flux = Flux.fromStream(Stream.generate(Math::random)).doOnNext(System.out::println);

		// Use StepVerifier to verify Flux emission
	}

	@Test
	public void verifyDelayedEmission() {

		Flux<Long> flux = Flux.interval(Duration.ofSeconds(5)).take(10).doOnNext(System.out::println);

		// Use StepVerifier to verify Flux emission, not spending 5 seconds per emission
	}
}
