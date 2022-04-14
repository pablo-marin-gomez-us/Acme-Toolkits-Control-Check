package acme.features.inventor.artifact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artifacts.Artifact;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorArtifactRepository extends AbstractRepository{

	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = 0")
	Collection<Artifact> findToolsByInventorId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.inventor.id = :id AND a.artifactType = 1")
	Collection<Artifact> findComponentsByInventorId(int id);
	
	@Query("SELECT a FROM Artifact a WHERE a.id = :id")
	Artifact findArtifactById(int id);

}
