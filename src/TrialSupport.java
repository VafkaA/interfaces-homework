public interface TrialSupport {
    // интерфейс для подписок с пробным периодом
    int trialDays();
    boolean isInTrial(int date);
}
