/*
 Navicat Premium Data Transfer

 Source Server         : MariaDb
 Source Server Type    : MariaDB
 Source Server Version : 100313
 Source Host           : localhost:3307
 Source Schema         : web_flux_db

 Target Server Type    : MariaDB
 Target Server Version : 100313
 File Encoding         : 65001

 Date: 10/02/2022 17:10:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `customer_type` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'Amal', '1234568', NULL);
INSERT INTO `customer` VALUES (2, 'AMAL sepala', '82148408V', 1);
INSERT INTO `customer` VALUES (3, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (4, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (5, 'kelum sepala', '821', 1);
INSERT INTO `customer` VALUES (6, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (7, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (8, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (9, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (10, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (11, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (12, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (13, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (14, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (15, 'kelum sepala', '821', 1);
INSERT INTO `customer` VALUES (16, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (17, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (18, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (19, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (20, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (21, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (22, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (23, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (24, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (25, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (26, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (27, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (28, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (29, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (30, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (31, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (32, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (33, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (34, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (35, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (36, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (37, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (38, 'kelum sepala', '6666', 1);
INSERT INTO `customer` VALUES (39, 'kelum sepala', '6666', 1);
INSERT INTO `customer` VALUES (40, 'kelum sepala', '6666', 1);
INSERT INTO `customer` VALUES (41, 'kelum sepala', '6666', 1);
INSERT INTO `customer` VALUES (42, 'kelum sepala', '6666', 1);
INSERT INTO `customer` VALUES (43, 'kelum sepala', '821484308V', 1);
INSERT INTO `customer` VALUES (44, 'kelum sepala', NULL, 1);
INSERT INTO `customer` VALUES (45, 'kelum sepala', NULL, 1);
INSERT INTO `customer` VALUES (46, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (47, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (48, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (49, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (50, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (51, 'kelum sepala', '', 1);
INSERT INTO `customer` VALUES (52, 'kelum sepala', '821', 1);
INSERT INTO `customer` VALUES (53, 'kelum sepala', '821', 1);
INSERT INTO `customer` VALUES (54, 'kelum sepala', '821', 1);
INSERT INTO `customer` VALUES (55, 'AMAL sepala', '82148408V', 1);
INSERT INTO `customer` VALUES (56, 'dsgsdg', '45454', 1);
INSERT INTO `customer` VALUES (57, 'rtyryrt', 'tyryr', 1);
INSERT INTO `customer` VALUES (58, 'Jagath', '65446464v', 1);
INSERT INTO `customer` VALUES (59, 'Dasun', '958844484', 1);
INSERT INTO `customer` VALUES (60, 'AMAL sepala', '82148408V', 1);
INSERT INTO `customer` VALUES (61, 'AMAL sepala..', '8214840855V', 1);
INSERT INTO `customer` VALUES (62, 'AMAL sepala..', '8214840855V', 1);
INSERT INTO `customer` VALUES (63, 'dsgsdg', '45454', 1);
INSERT INTO `customer` VALUES (64, 'dsgsdg', '45454', 1);
INSERT INTO `customer` VALUES (65, 'jhkhkhjkh hgjgjg ffjg', 'jhkh', 1);
INSERT INTO `customer` VALUES (66, 'xxxxxxxxxxxxxxxxx', 'ccccccccc', 1);
INSERT INTO `customer` VALUES (67, 'ssssssssssss', '4444444444444444', 2);
INSERT INTO `customer` VALUES (68, 'Amal', '1234568', NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL,
  `order_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 'Order1');
INSERT INTO `order` VALUES (2, 'Oder Item 2');

-- ----------------------------
-- Table structure for order_customer
-- ----------------------------
DROP TABLE IF EXISTS `order_customer`;
CREATE TABLE `order_customer`  (
  `order_customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `order_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_customer_id`) USING BTREE,
  INDEX `fk_xxxxss`(`customer_id`) USING BTREE,
  INDEX `fk_xx1`(`order_id`) USING BTREE,
  CONSTRAINT `fk_xx1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_xxxxss` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_customer
-- ----------------------------
INSERT INTO `order_customer` VALUES (1, 1, 1, '2021-05-14 04:00:00');
INSERT INTO `order_customer` VALUES (2, 1, 1, '2021-05-15 00:00:00');
INSERT INTO `order_customer` VALUES (3, 1, 6, '2021-05-11 14:42:43');

SET FOREIGN_KEY_CHECKS = 1;
