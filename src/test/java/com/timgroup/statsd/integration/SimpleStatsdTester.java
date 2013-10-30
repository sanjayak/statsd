package com.timgroup.statsd.integration;

import java.util.Random;

import com.timgroup.statsd.NonBlockingStatsDClient;

public class SimpleStatsdTester {

	NonBlockingStatsDClient client = new NonBlockingStatsDClient("SimpleStatsdTester",
			"localhost", 8125);

	/*
	 * worse case time taken to execute function is 100 seconds
	 */
	private void timeConsumingMethod() {
		int counter = 0;

		while (counter < 20) {

			long time = System.currentTimeMillis();
			client.increment("timeConsumingMethod");
			try {
				Thread.sleep(1000 * new Random().nextInt(20));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter++;
			long timeTaken = System.currentTimeMillis() - time;

			System.out.println("Counting on " + counter + "pusing data to statsd " + timeTaken );
			client.time("timeConsumingMethod", (int) timeTaken);
		}
	}

	public static void main( String a[] ){
		new SimpleStatsdTester().timeConsumingMethod();;
	}
}
