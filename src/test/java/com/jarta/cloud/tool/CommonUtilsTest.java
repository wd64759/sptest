package com.jarta.cloud.tool;


import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtilsTest {
	
	@Test
	public void objEquals() {
		Assert.assertTrue(Objects.equals(new Integer(1), 1));
	}
}
