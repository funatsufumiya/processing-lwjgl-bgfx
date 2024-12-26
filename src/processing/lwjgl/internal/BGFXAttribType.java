package processing.lwjgl.internal;

public enum BGFXAttribType {
    UINT8(0),
    UINT10(1),
    INT16(2),
    HALF(3),
    FLOAT(4)
    ;
    public final int value;
    private BGFXAttribType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getCount() {
        return values().length;
    }
    public static BGFXAttribType valueOf(int value) {
        for (BGFXAttribType format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}