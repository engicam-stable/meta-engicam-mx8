FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-add-sn65dsi83-driver-and-drm-fix.patch \
    file://0002-add-icore-support.patch \
    file://0003-add-icoremx8mm_defconfig.patch \
    file://0004-fix-drm-section.patch \
    file://0005-add-sgtl5000-support.patch \
    file://0006-fix-on-icoremx8mm-defconfig.patch \
    file://0007-remove-CAAM-from-defconfig.patch \
    file://0009-add-iCoreMX8M-support.patch \
    file://0010-add-hdmi-dtb-imx8m.patch \
    file://0011-add-edt-ft5x26-driver.patch \
    file://0012-fix-starter-kit-2.0-support.patch \
    file://0013-fix-icoremx8m-support.patch \
    file://0014-fix-edimm-2.0-starterkit-lcd-timing.patch \
    file://0015-add-edimm-2.0-starter-kit-touch-controller-support.patch \
    file://0016-fix-hub-usb-reset.patch \
    file://0021-added-support-for-fullhd-display-on-icoremx8mm-linux4.14.98.patch \
    file://0017-add-ctouch2-imx8mm-amp-10-dtb.patch \
    file://0018-remove-useless-i2c-touch-entry.patch \
    file://0019-remove-ov5640-entry.patch \
    file://0020-add-CONFIG_DRM_VIVANTE-flag-on-config.patch \
    file://0022-added-icoremx8x-support.patch \
    file://0023-Fixed-issues-on-dts-for-icore-mx8x-for-lcd-resolutio.patch \
    file://0024-added-default-config-for-icore-mx8x.patch \
    file://0025-add-icoremx8m-defconfig.patch \
    file://0026-add-core-imx8xd.dts.patch \
    "
