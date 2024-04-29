package si.primoz;

public record StreamData(String matchId, String marketId, String outcomeId, String specifiers) implements Comparable<StreamData> {

    @Override
    public int compareTo(StreamData o) {
        if(this.matchId.compareTo(o.matchId) != 0) {
            return this.matchId.compareTo(o.matchId);
        } else if(this.marketId.compareTo(o.marketId) != 0) {
            return this.marketId.compareTo(o.marketId);
        } else if(this.outcomeId.compareTo(o.outcomeId) != 0) {
            return this.specifiers.compareTo(o.specifiers);
        } else {
            return this.specifiers.compareTo(o.specifiers);
        }
    }
}