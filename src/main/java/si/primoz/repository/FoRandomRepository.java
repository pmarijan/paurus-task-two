package si.primoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.primoz.model.FoRandom;

@Repository
public interface FoRandomRepository extends JpaRepository<FoRandom, Long> {
}
