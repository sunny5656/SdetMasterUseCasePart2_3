package com.sdet.labs;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restful_Web_Services_Test {
	
	@BeforeTest
	  public void beforeTest() {
		  Restful_Web_Services.setup();
	  }

	  @Test
	  public void DeleteRequestTest() {
		  Assert.assertEquals(Restful_Web_Services.DeleteRequestStatusCode(),200);
	  }

	  @Test
	  public void GetRequestTest() {
		  Assert.assertEquals(Restful_Web_Services.GetRequestStatusCode(),200);
	  }

	  @Test
	  public void PatchRequestTest() {
		  Assert.assertEquals(Restful_Web_Services.PatchRequestStatusCode(),200);
	  }

	  @Test
	  public void PostRequestTest() {
		  Assert.assertEquals(Restful_Web_Services.PostRequestStatusCode(),201);
	  }

	  @Test
	  public void PutRequestTest() {
		  Assert.assertEquals(Restful_Web_Services.PutRequestStatusCode(),200);
	  }

}
