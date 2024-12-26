package processing.lwjgl.internal;

public enum BGFXUniformType {
    SAMPLER(0),
    END(1), // Reserved, do not use
    VEC4(2), // 4 floats vector
    MAT3(3), // 3x3 matrix
    MAT4(4) // 4x4 matrix
    ;
    public final int value;
    private BGFXUniformType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getCount() {
        return values().length;
    }
    public static BGFXUniformType valueOf(int value) {
        for (BGFXUniformType format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}
