package com.corporate.knowledge.test.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.rule.PowerMockRule;

import com.corporate.knowledge.test.model.Candidate;
import com.corporate.knowledge.test.service.persistence.CandidatePersistence;

public class CandidateLocalServiceImplTest {

	@Rule
	public PowerMockRule powerMockRule = new PowerMockRule();

	@Mock
	private CandidatePersistence candidatePersistence;

	@InjectMocks
	private CandidateLocalServiceImpl candidateLocalService;

	@Mock
	Candidate candidate1;

	@Mock
	Candidate candidate2;

	List<Candidate> candidates;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		candidates = Arrays.asList(candidate1, candidate2);
		when(candidatePersistence.findAll()).thenReturn(candidates);
		when(candidate1.getCandidateId()).thenReturn(1l);
		when(candidate1.getName()).thenReturn("Benito");
		when(candidate2.getName()).thenReturn("Antonio");
		when(candidate2.getCandidateId()).thenReturn(2l);

	}

	// TODO Ejercicio 2.d: Añadir un nuevo test unitario del servicio anterior en CandidateLocalServiceImplTest

	// TODO Ejercicio 3.b: Arreglar el test unitario del servicio anterior en CandidateLocalServiceImplTest
	@Test
	public void testGetAllCandidatesOrdered() {

		assertTrue(candidates.get(0)
							 .getCandidateId() == 1l);
		assertTrue(candidates.get(1)
							 .getCandidateId() == 2l);
		List<Candidate> candidates = candidateLocalService.getAllCandidatesOrdered();
		assertTrue(candidates.size() == 2);
		assertTrue(candidates.get(0)
							 .getName()
							 .compareTo(candidates.get(1)
												  .getName()) == 1);
		assertTrue(candidates.get(0)
							 .getCandidateId() == 1l);
		assertTrue(candidates.get(0)
							 .getName()
							 .equals("Benito"));
		assertTrue(candidates.get(1)
							 .getCandidateId() == 2l);
		assertTrue(candidates.get(1)
							 .getName()
							 .equals("Antonio"));

	}

}
