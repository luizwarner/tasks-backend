package br.ce.wcaquino.taskbackend.test;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.taskbackend.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void retornarFalseParaDataAnteriores() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
	}
	
	@Test
	public void retornarTrueParaDataPosterior() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
	}
	
	@Test
	public void retornarTrueParaDataIgual() {
		LocalDate date = LocalDate.now();
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
	}
}