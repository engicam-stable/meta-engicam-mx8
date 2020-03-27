DESCRIPTION = "Engicam image for hardware test"

LICENSE = "MIT"

inherit core-image

EXTRA_IMAGE_FEATURES = " debug-tweaks ssh-server-openssh tools-debug "


IMAGE_INSTALL_append = " \
  \
  alsa-state \
  alsa-tools \
  alsa-utils \
  \
  binutils \
  \
  canutils \
  coreutils \
  cpufrequtils \
  \
  devmem2 \
  dosfstools \
  \
  e2fsprogs \
  ethtool \
  evtest \
  \
  fbset \
  fsl-alsa-plugins \
  \
  gstreamer1.0-rtsp-server \
  \
  i2c-tools \
  imx-kobs \
  imx-test \
  iproute2 \
  \
  ldd \
  \
  minicom \
  \
  packagegroup-fsl-gstreamer1.0-full \
  psplash \
  \
  serialtools \
  \
  test-sound \
  tslib \
  tslib-calibrate \
  tslib-conf \
  tslib-tests \
  \
  usbutils \
  util-linux \
  \
  v4l-utils \
"

