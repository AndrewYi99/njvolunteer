/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : njvolunteer

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-05-28 22:24:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user''s name',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'login password',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'value for cookie',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', '123', '5af6a8ec-42e3-4955-9698-37eea21e8b10');
INSERT INTO `user` VALUES ('2', 'root', 'root', 'e68ff06f-c1b6-49cb-8934-52f04b0e4f90');
