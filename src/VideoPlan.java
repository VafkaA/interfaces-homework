public class VideoPlan extends Subscription implements Billable, Pausable, Sharable {
   int maxProfiles;
   String[] members = new String[maxProfiles];
   PauseWindow[] pauses = new PauseWindow[5];
   int date;

    public VideoPlan(String id, String title, float monthlyPrice, int startDate, boolean active, int maxProfiles, String[] members, PauseWindow[] pauses, int date) {
        super(id, title, monthlyPrice, startDate, active);
        this.maxProfiles = maxProfiles;
        this.members = members;
        this.pauses = pauses;
        this.date = date;
    }

    @Override
    public float monthlyCharge(float forMonth) {
        if (!active) return 0;
        if (pauses.length == 0) return forMonth * monthlyPrice;
        int noActiveDays = 0;
        for (int i = 0; i < pauses.length; i++) {
            if (pauses[i] != null) noActiveDays++;
        }
        float activeDays = (forMonth * 30) - noActiveDays;
        return activeDays * (monthlyPrice / 30);
    }

    @Override
    public void pause(int from, int to) {
        for (int i = 0; i < pauses.length; i++) {
            if (pauses[i] == null) {
                pauses[i] = new PauseWindow(from, to);
                return;
            }
        }
    }

    @Override
    public boolean isPausedOn(int date) {
        if (pauses.length == 0) return false;
        for (int i = 0; i < pauses.length; i++) {
            if (pauses[i] == null) continue;
            if (date >= pauses[i].getFrom() || date <= pauses[i].getTo())
                return true;
        }
        return false;
    }

    @Override
    public int maxProfiles() {
        maxProfiles = 4;
        return maxProfiles;
    }

    @Override
    public void addMember(String userId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) members[i] = userId;
            return;
        }
    }

    @Override
    public void removeMember(String userId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) members[i] = null;
            return;
        }
    }
}
