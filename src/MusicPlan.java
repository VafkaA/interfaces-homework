public class MusicPlan extends Subscription implements Billable, TrialSupport  {
    private int date;
    private float forMonth;
    private int trialDays;

    public MusicPlan(String id, String title, float monthlyPrice, int startDate, boolean active, int date, float forMonth, int trialDays) {
        super(id, title, monthlyPrice, startDate, active);
        this.date = date;
        this.forMonth = forMonth;
        this.trialDays = 14;
    }
    @Override
    public int trialDays(){
        return trialDays;
    }
    @Override
    public float monthlyCharge(float forMonth){
        if (!active) return 0;
        if (forMonth == 1) {
         return (forMonth*30 - 14)*(monthlyPrice/30);
        }
        return monthlyPrice;
    }
    @Override
    public boolean isInTrial(int date){
        return date - startDate <= trialDays;
    }
}
