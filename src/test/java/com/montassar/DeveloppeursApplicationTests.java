package com.montassar;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.montassar.entities.Developpeur;
import com.montassar.repos.DeveloppeurRepository;
import com.montassar.services.DeveloppeurService;

@SpringBootTest
class DeveloppeursApplicationTests {

	@Autowired
	private DeveloppeurRepository developpeurRepository;
	@Autowired
	private DeveloppeurService developpeurService;
	
	
	@Test
	public void testCreateDeveloppeur() {
		Developpeur dev=new Developpeur("Ali",1300.0,new Date());
		developpeurRepository.save(dev);
	}
	
	@Test
	public void testFindDeveloppeur()
	{
		Developpeur d=developpeurRepository.findById(1L).get();
		System.out.println(d);
	}
	@Test
	public void testUpdateDeveloppeur()
	{
		Developpeur d=developpeurRepository.findById(1L).get();
		d.setSalaire(1800.0);
		developpeurRepository.save(d);
	}
	
	@Test
	public void testDeleteDeveloppeur()
	{
		developpeurRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousDeveloppeurs()
	{
		List<Developpeur> devs=developpeurRepository.findAll();
		for(Developpeur d:devs)
		{
			System.out.println(d);
		}
	}
	
	@Test
	public void testFindByNomDeveloppeurContains()
	{
	Page<Developpeur> devs = developpeurService.getAllDeveloppeursParPage(0,2);
	System.out.println(devs.getSize());
	System.out.println(devs.getTotalElements());
	System.out.println(devs.getTotalPages());

	devs.getContent().forEach(d -> {System.out.println(d.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}


}
