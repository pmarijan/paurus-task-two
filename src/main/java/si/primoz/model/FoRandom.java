package si.primoz.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fo_random")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FoRandom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private long id;

    @Column(name = "match_id")
    private String matchId;

    @Column(name = "market_id")
    private String marketId;

    @Column(name = "outcome_id")
    private String outcomeId;

    @Column(name = "specifiers")
    private String specifiers;

    @CreatedDate
    @Column(name = "insert_time")
    private Instant insert_time;
}
