package acme.features.patron.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronArtifactRepository extends AbstractRepository{

	
	@Query("SELECT q.artifact FROM Quantity q WHERE q.artifact.chimpum.id =:id and q.artifact.published=true")
	Collection<Artifact> findToolsAndComponentsByCHIMPUMId(int id);

}
