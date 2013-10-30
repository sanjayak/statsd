package com.timgroup.statsd.impl;

import com.timgroup.statsd.NonBlockingStatsDClient;

public class Test {

	public static void main( String a [] ){
		NonBlockingStatsDClient client = new NonBlockingStatsDClient("Test", "localhost", 8125);

		client.increment( "TestMethod");

	}
}
