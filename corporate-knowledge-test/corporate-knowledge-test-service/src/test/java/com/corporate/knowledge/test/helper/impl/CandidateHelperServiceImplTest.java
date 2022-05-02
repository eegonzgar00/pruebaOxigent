package com.corporate.knowledge.test.helper.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.rule.PowerMockRule;

// TODO Ejercicio 1.d: Implementar el test unitario (o los tests unitarios) del método validateName para probar varios casos de uso

public class CandidateHelperServiceImplTest {

	@Rule
	public PowerMockRule powerMockRule = new PowerMockRule();

	@InjectMocks
	private CandidateHelperServiceImpl candidateHelperServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidateName() {
		assertTrue(candidateHelperServiceImpl.validateName("dummy"));
	}

}
