package constants;

/**
 * Enum representing HTTP status codes with associated integer values.
 */
public enum StatusCode {

    OK_200(200),
    NOT_FOUND_404(404);

    private final int getCode;

    StatusCode(int code) {
        this.getCode = code;
    } // constructor to assign

    /**
     * Gets the integer representation of the HTTP status code.
     *
     * @return The integer value of the HTTP status code.
     */
    public int getCode() {
        return getCode;
    }

}
