package org.healthonnet.spellcheck.levenstein.test;

import org.healthonnet.spellcheck.levenstein.NormalizedLevensteinDistance;
import org.junit.Assert;
import org.junit.Test;

public class LevensteinTest {

	private static final double MIN = 0.0001;
	
	@Test
	public void testLevenstein() {
		
		NormalizedLevensteinDistance distance = new NormalizedLevensteinDistance();
		
		Assert.assertEquals(0.8, distance.getDistance("candi", "candy"), MIN);
		Assert.assertEquals(0.8, distance.getDistance("candi", "candid"), MIN);
		Assert.assertEquals(0.0,distance.getDistance("candi", "candiiiiiiiiiiiiiiiiiiiiiiiiiii"), MIN);
		Assert.assertEquals(0.0,distance.getDistance("candi", ""), MIN);
		Assert.assertEquals(0.0,distance.getDistance("candi", "fruit"), MIN);
		Assert.assertEquals(0.0,distance.getDistance("", "fruit"), MIN);
		Assert.assertEquals(0.0,distance.getDistance("f", "fruit"), MIN);
		Assert.assertEquals(0.0,distance.getDistance("fr", "fruit"), MIN);
		Assert.assertEquals(0.333333,distance.getDistance("fru", "fruit"), MIN);
		Assert.assertEquals(0.75,distance.getDistance("frui", "fruit"), MIN);
	}
}
