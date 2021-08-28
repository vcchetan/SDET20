package com.vtiger.takebizglobal.packagefordistributedExec;

import org.testng.annotations.Test;

public class ClassForDitributedParallelExecTest3 {
	@Test
	public void CreateProd() {
		System.out.println("Creates the product");
	}
	
	@Test
	public void CreateProdWithPartNum() {
		System.out.println("Creates the product with part number");
	}
	
	@Test
	public void CreateProdWithCommRate() {
		System.out.println("Creates the product with comm rate");
	}

}
