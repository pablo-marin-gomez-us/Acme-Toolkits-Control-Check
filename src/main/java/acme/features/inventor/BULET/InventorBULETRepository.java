package acme.features.inventor.BULET;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.BULET.BULET;
import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorBULETRepository extends AbstractRepository{
	

	@Query("select c from BULET c")
	Collection<BULET> findAllBULET();
	
	@Query("select c from BULET c WHERE c.code LIKE :pattern%")
	List<BULET> findAllBULETBySimilarPattern(String pattern);
	
	@Query("select c from BULET c where c.id = :id")
	BULET findBULETById(int id);
	
	@Query("select a from Artifact a where a.id = :id")
	Artifact findARTIFACTById(int id);
	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.artifact.bulet.id =:id")
	Collection<Artifact> findToolsAndComponentsByBULETId(int id);

	
	@Query("select config.strongSpamTerms from ConfigData config")
	String findStrongSpamTerms();
	
	@Query("select config.weakSpamTerms from ConfigData config")
	String findWeakSpamTerms();
	
	@Query("select config.strongSpamTreshold from ConfigData config")
	int findStrongSpamTreshold();
	
	@Query("select config.weakSpamTreshold from ConfigData config")
	int findWeakSpamTreshold();
	
	@Query("select cd.acceptedCurrencies from ConfigData cd")
	String acceptedCurrencies();
	

}
