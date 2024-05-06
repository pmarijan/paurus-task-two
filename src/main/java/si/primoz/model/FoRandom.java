package si.primoz.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fo_random")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FoRandom implements Comparable<FoRandom> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "fo_random_seq", allocationSize = 200)
    @EqualsAndHashCode.Include
    @ToString.Include
    private long id;

    @ToString.Include
    @Column(name = "match_id")
    private String matchId;

    @ToString.Include
    @Column(name = "market_id")
    private String marketId;

    @ToString.Include
    @Column(name = "outcome_id")
    private String outcomeId;

    @ToString.Include
    @Column(name = "specifiers")
    private String specifiers;

    @ToString.Include
    @Column(name = "insert_time", updatable = false, insertable = false)
    private Instant insert_time;

    public FoRandom(String matchId, String marketId, String outcomeId, String specifiers) {
        this.matchId = matchId;
        this.marketId = marketId;
        this.outcomeId = outcomeId;
        this.specifiers = specifiers;
    }

    @Override
    public int compareTo(FoRandom o) {
        if(this.matchId.compareTo(o.matchId) != 0) {
            return this.matchId.compareTo(o.matchId);
        } else if(this.marketId.compareTo(o.marketId) != 0) {
            return this.marketId.compareTo(o.marketId);
        } else if(this.outcomeId.compareTo(o.outcomeId) != 0) {
            return this.outcomeId.compareTo(o.outcomeId);
        } else {
            return this.specifiers.compareTo(o.specifiers);
        }
    }
}
