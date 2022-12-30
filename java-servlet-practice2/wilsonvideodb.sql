/*
 Navicat Premium Data Transfer

 Source Server         : danny_mySQL
 Source Server Type    : MySQL
 Source Server Version : 100703 (10.7.3-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : wilsonvideodb

 Target Server Type    : MySQL
 Target Server Version : 100703 (10.7.3-MariaDB)
 File Encoding         : 65001

 Date: 04/12/2022 19:24:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` int NULL DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`BookID`) USING BTREE,
  UNIQUE INDEX `BookID`(`BookID` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'sfasf', 45, 'asfsaf');
INSERT INTO `book` VALUES (2, 'sfasf', 45, 'asfas');
INSERT INTO `book` VALUES (5, 'belly', 60, 'danny');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `videoId` int NOT NULL AUTO_INCREMENT,
  `videoName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  PRIMARY KEY (`videoId`) USING BTREE,
  UNIQUE INDEX `Video_videoId_uindex`(`videoId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (65, 'HarryPotter', 66);
INSERT INTO `video` VALUES (66, 'Avengers', 86);

SET FOREIGN_KEY_CHECKS = 1;
