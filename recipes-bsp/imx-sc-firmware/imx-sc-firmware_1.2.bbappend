FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += " file://mx8qx-icore-scfw-tcm.bin "

do_deploy_prepend() {
      cp ../mx8qx-icore-scfw-tcm.bin .
}
