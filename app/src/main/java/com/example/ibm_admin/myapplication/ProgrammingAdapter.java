package com.example.ibm_admin.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingAdapterHolder> {


    private  Context context;
    private TicketDetail[] data;

    public  ProgrammingAdapter(Context context, TicketDetail[] data)
    {
        this.context=context;
        this.data=data;

    }


    @NonNull
    @Override
    public ProgrammingAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_ticket_layout, viewGroup, false);
        return  new ProgrammingAdapterHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingAdapterHolder programmingAdapterHolder, int i) {

        TicketDetail detail = data[i];
        programmingAdapterHolder.txtTicketNumber.setText(detail.getTicketNumber());
        programmingAdapterHolder.txtOwnerGroup.setText(detail.getOwnerGroup());
        programmingAdapterHolder.txtOwnerName.setText(detail.getOwnerName());
        programmingAdapterHolder.txtSummary.setText(detail.getSummary());
        programmingAdapterHolder.txtSeverty.setText(detail.getSeverty());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingAdapterHolder extends RecyclerView.ViewHolder{

        TextView txtTicketNumber;
        TextView txtOwnerGroup;
        TextView txtOwnerName;
        TextView txtSummary;
        TextView txtSeverty;

        public ProgrammingAdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtTicketNumber = itemView.findViewById(R.id.textTicketNumber);
            txtOwnerGroup = itemView.findViewById(R.id.textOwnerGroup);
            txtOwnerName = itemView.findViewById(R.id.textOwnerName);
            txtSummary = itemView.findViewById(R.id.textTicketSummary);
            txtSeverty = itemView.findViewById(R.id.textSeverty);
        }
    }
}
