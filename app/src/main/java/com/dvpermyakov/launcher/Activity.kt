package com.dvpermyakov.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class Activity : AppCompatActivity() {

    private val adapter = ApplicationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.items = getApplicationItems()
    }

    private fun getApplicationItems(): List<ApplicationItem> {
        return packageManager.getInstalledApplications(0)
            .filter { appInfo ->
                packageManager.getLaunchIntentForPackage(appInfo.packageName) != null
            }
            .map { appInfo ->
                ApplicationItem(
                    name = appInfo.loadLabel(packageManager).toString(),
                    packageName = appInfo.packageName,
                    icon = appInfo.loadIcon(packageManager),
                    intent = packageManager.getLaunchIntentForPackage(appInfo.packageName)
                )
            }
    }

}