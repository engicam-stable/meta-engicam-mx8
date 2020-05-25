SECTION = "kernel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit module

DEPENDS += "coreutils-native"

S = "${WORKDIR}/laird-backport-${PV}"

LRD_LWB_URI_BASE = "https://github.com/LairdCP/Sterling-LWB-and-LWB5-Release-Packages/releases/download/LRD-REL-${PV}"

BACKPORTS_FILE = "backports-laird-${PV}.tar.bz2"

EXTRA_OEMAKE = "\
	KLIB_BUILD=${STAGING_KERNEL_DIR} \
	KLIB=${D} \
	DESTDIR=${D} \
	KERNEL_CONFIG=${STAGING_KERNEL_BUILDDIR}/.config \
	KMODDIR=updates \
	INSTALL_MOD_DIR=updates \
	BACKPORT_DIR=${S} \
	M=${S} \
	"

do_compile_prepend() {
	rm -f ${S}/.kernel_config_md5
	oe_runmake CC=${BUILD_CC} ${BACKPORTS_CONFIG}
}

do_install_prepend () {
	cd ${STAGING_KERNEL_DIR}
}