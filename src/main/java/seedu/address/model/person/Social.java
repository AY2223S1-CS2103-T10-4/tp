package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's social media in the address book.
 */
public class Social {

    public static final String MESSAGE_CONSTRAINTS =
            "Social media handles should be social_media@username.";

    /*
     * The first character of the social must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = ".*@.*";

    private final String handle;
    private final String platform;

    /**
     * Constructs a {@code Social}.
     *
     * @param fullString A valid social media string, in the form of platform@handle
     */

    public Social(String fullString) {
        requireNonNull(fullString);
        checkArgument(isValidSocial(fullString), MESSAGE_CONSTRAINTS);
        String[] fullStringArray = fullString.split("@");
        this.handle = fullStringArray[0];
        this.platform = fullStringArray[1];
    }

    /**
     * Constructs a {@code Social}.
     *
     * @param handle A valid social media handle
     * @param platform A valid social media platform
     */

    public Social(String handle, String platform) {
        requireNonNull(handle);
        requireNonNull(platform);
        checkArgument(isValidSocial(handle + "@" + platform), MESSAGE_CONSTRAINTS);
        this.handle = handle;
        this.platform = platform;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidSocial(String test) {
        String[] strArray = test.split("@");
        return strArray.length == 2 && !strArray[0].equals("") && !strArray[1].equals("")
                && test.matches(VALIDATION_REGEX);
    }

    public String toString() {
        return this.platform + "@" + this.handle;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        } else if (!(other instanceof Social)) {
            return false;
        }

        Social s = (Social) other;

        return this.platform.equals(s.platform) && this.handle.equals(s.handle);

    }

}
