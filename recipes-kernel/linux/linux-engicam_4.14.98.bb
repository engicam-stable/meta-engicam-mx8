SUMMARY = "Linux Kernel provided and supported by Engicam"
DESCRIPTION = "Linux Kernel provided and supported by Engicam with"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel fsl-kernel-localversion fsl-vivante-kernel-driver-handler

# Put a local version until we have a true SRCREV to point to
LOCALVERSION ?= ""
SCMVERSION ?= "y"
SRCBRANCH ?= ""

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

SRC_URI = "git://github.com/engicam-stable/linux-engicam_4.14.98.git;protocol=git;branch=linux-engicam_4.14.98"
SRCREV = "32f21d3c0ca7b49b9c604e6ed1f05201ee60a90a"

SRC_URI_append_mx8mm += "file://0001-fix-reboot.patch"

S = "${WORKDIR}/git"

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
        install -d ${B}
        mkdir -p ${B}
        cp  ${KBUILD_DEFCONFIG} ${WORKDIR}/.config
        cp  ${KBUILD_DEFCONFIG} ${WORKDIR}/defconfig
}

COMPATIBLE_MACHINE = "(mx8|mx6)"
