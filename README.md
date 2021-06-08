# googleChartHtmlLoader
This in a sample app that can populate a chart provide by google chart with json data. The chart itself is wrapped as in-project html file, which is located inside assets folder.
The main methods is located inside MainActivity.kt. First it try to construct json data (it can altered depend on your need, it even can be set programmatically). After the json is constructed, the apps will send that json to html by attach it at URL. The HTML file includes some logic to read data from URL and to draw google chart itself.
