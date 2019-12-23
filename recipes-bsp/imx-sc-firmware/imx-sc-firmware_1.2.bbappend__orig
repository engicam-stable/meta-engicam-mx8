FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://mx8qx-icore-scfw-tcm.bin "

BOARD_TYPE = "icore"

do_deploy_prepend() {
    cp ../mx8qx-icore-scfw-tcm.bin .
}
