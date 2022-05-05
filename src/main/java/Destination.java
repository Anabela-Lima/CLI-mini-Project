public enum Destination {
    BALI,
    BORABORA,
    COSTARICA,
    DUBAI,
    FIJI,
    HAWAII,
    ITALY,
    MALDIVES,
    MOROCCO,
    NEWYORK,
    SAOTOME,
    SEYCHELLES,
    SYDNEY;

    public static boolean CheckDestination(String destination) {
        destination = destination.toUpperCase();
        for (Destination place : Destination.values()) {
            if (place.name().equals(destination)) {
                return true;
            }
        }

        return false;
    }



}





