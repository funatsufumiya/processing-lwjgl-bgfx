## Processing LWJGL Library BGFX Fork

This is based on [processing-lwjgl](https://github.com/codeanticode/processing-lwjgl)

NOTE: **WORK IN PROGRESS, NOT READY FOR USE** (and may not maintained. If you want similar library as for now, please consider [minimax](https://github.com/funatsufumiya/minimax))

### Current Status

- [x] `./gradlew runHelloBGFX` works (this don't use the Processing API)
- [x] show blank window (`./gradlew runEmptySketch`)
- [x] `./gradlew runBackgroundSketch` works 

### TODO (and features)

- [x] Window (Basic)
- [x] Background (Clear)
- [ ] Texture
- [ ] FBO
- [ ] Image
- [ ] Shader
- [ ] 2D: Rect
- [ ] 2D: Line
- [ ] 2D: Ellipse
- [ ] 3D: Camera (LookAt)
- [ ] 3D: Light (Basic)
- [ ] 3D: Box
- [ ] 3D: Sphere

NOTE: Currently, most of the PLWJGL code is commented out, and throws `NotImplementedException` when called.

### Build

```
./gradlew buildExample
```

NOTE: This is optional when you [Run](#run) the example. (This is automatically done by the `run` task)

### Run

#### Processing Example

```
./gradlew runEmptySketch
```

#### Plain GLFW/BGFX Example

```
./gradlew runHelloBGFX
```


-----

(Original README)

## Processing LWJGL library

This is a Processing library that offers LWJGL-based 2D and 3D renderers. [LWJGL](https://www.lwjgl.org/) is a Java library that enables cross-platform access to graphics APIs.
