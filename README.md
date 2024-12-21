## Processing LWJGL BGFX Fork

This is based on [processing-lwjgl](https://github.com/codeanticode/processing-lwjgl)

### Current Status

- [x] `./gradlew runHelloBGFX` works (this don't use the Processing API)
- [x] show blank window

NOTE: Currently, most of the PLWJGL code is commented out, and throws `NotImplementedException` when called.

### Run

#### Processing Example

```
./gradlew buildExample
./gradlew runExample
```

#### Plain GLFW/BGFX Example

```
./gradlew buildHelloBGFX
./gradlew runHelloBGFX
```


-----

## Processing LWJGL library

This is a Processing library that offers LWJGL-based 2D and 3D renderers. [LWJGL](https://www.lwjgl.org/) is a Java library that enables cross-platform access to graphics APIs.