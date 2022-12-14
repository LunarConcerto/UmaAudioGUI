# UmaAudioGUI
一个简单的对《赛马娘》的音频进行导出的工具.

纯粹为了实现功能以及便利的使用而编写的程序, 空间复杂度稍显丑陋, 只能说能用就行.

为了便于发行，在发行包中捆绑了jre，且本身程序是由javafx编写的，打包时包含了javafx相关的运行库。因此容量稍微有点难看。

## 用法
![Z ~ S69WW%)8B3GWH%5 TJ](https://user-images.githubusercontent.com/41500314/187111683-a24b846c-8070-40ac-8349-0fc8cbc52b66.jpg)

__点击 `增加条件` ，且在新弹出的输入框中输入字符，可设置过滤出包含该字符串的文件__

__点击 `读取资源列表` 将刷新左侧显示的文件列表，该列表是之后将被导出的文件__

__点击 `浏览...` 选择文件的导出目录__

__点击 `导出` 即可开始将对应文件导出到指定的导出目录.__

## 注意事项

+ 导出后的 `.awb` 文件可能无法直接用系统的音频播放器进行播放，如有需求，请移步 [VgmStream](https://github.com/vgmstream/vgmstream) 使用 __vgmstream-cli__ 对文件进行解码，
如果用过Foobar2000, 推荐使用Foobar2000的vgmstream插件，可直接播放.awb文件，亦可直接将.awb文件转换为其他格式。
+ 确保赛马娘的资源包能够在路径 `C://Users/Administrator/AppData/LocalLow/Cygames/umamusume` 中找到，目前还未提供资源路径修改的功能。

## 鸣谢

感谢b站 [KaorinP_plkm160](https://space.bilibili.com/9102731) 老师提供的指导.
