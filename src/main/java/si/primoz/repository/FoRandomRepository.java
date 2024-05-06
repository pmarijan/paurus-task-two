package si.primoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.primoz.model.FoRandom;

import java.time.Instant;

@Repository
public interface FoRandomRepository extends JpaRepository<FoRandom, Long> {

    @Query("""
            SELECT MIN(fo.insert_time)
            FROM FoRandom fo
            """)
    Instant findMinTimestamp();

    @Query("""
            SELECT MAX(fo.insert_time)
            FROM FoRandom fo
            """)
    Instant findMaxTimestamp();
}
