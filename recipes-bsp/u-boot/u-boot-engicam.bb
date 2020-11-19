# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP

DESCRIPTION = "i.MX U-Boot suppporting Engicam boards."
require u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc
inherit pythonnative

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PROVIDES += "u-boot"
DEPENDS_append = " dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://github.com/engicam-stable/u-boot-engicam_5.4.47.git;protocol=https"
SRCBRANCH = "imx_v2020.04_5.4.47_2.2.0"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "1b26fc5a21bad3199bc86aa323fa44ec589b174f"

UBOOT_SRC_mx8mm ?= "git://github.com/engicam-stable/u-boot-engicam_2019.04.git;protocol=https"
SRCBRANCH = "u-boot-engicam_2019.04_4.19.35"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "40c516e01a46c324acc1f1f0223cd5d30176350d"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

BOOT_TOOLS = "imx-boot-tools"

do_deploy_append_mx8m () {
    # Deploy u-boot-nodtb.bin and fsl-imx8mq-XX.dtb, to be packaged in boot binary by imx-boot
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            i=$(expr $i + 1);
            for type in ${UBOOT_CONFIG}; do
                j=$(expr $j + 1);
                if [ $j -eq $i ]
                then
                    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${type}
                fi
            done
            unset  j
        done
        unset  i
    fi

}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

UBOOT_NAME_mx6 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx8 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
