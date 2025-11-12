public interface Sharable {
    // интерфейс для предоставления доступа людям к подписке
        int maxProfiles();
        void addMember(String userId);
        void removeMember(String userId);
}
