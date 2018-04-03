import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { PublisherOptJob } from './publisher-opt-job.model';
import { PublisherOptJobPopupService } from './publisher-opt-job-popup.service';
import { PublisherOptJobService } from './publisher-opt-job.service';
import { CampaignOptJob, CampaignOptJobService } from '../campaign-opt-job';
import { BlackListOptJob, BlackListOptJobService } from '../black-list-opt-job';

@Component({
    selector: 'jhi-publisher-opt-job-dialog',
    templateUrl: './publisher-opt-job-dialog.component.html'
})
export class PublisherOptJobDialogComponent implements OnInit {

    publisher: PublisherOptJob;
    isSaving: boolean;

    campaigns: CampaignOptJob[];

    blacklists: BlackListOptJob[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private publisherService: PublisherOptJobService,
        private campaignService: CampaignOptJobService,
        private blackListService: BlackListOptJobService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.campaignService.query()
            .subscribe((res: HttpResponse<CampaignOptJob[]>) => { this.campaigns = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.blackListService.query()
            .subscribe((res: HttpResponse<BlackListOptJob[]>) => { this.blacklists = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.publisher.id !== undefined) {
            this.subscribeToSaveResponse(
                this.publisherService.update(this.publisher));
        } else {
            this.subscribeToSaveResponse(
                this.publisherService.create(this.publisher));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<PublisherOptJob>>) {
        result.subscribe((res: HttpResponse<PublisherOptJob>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: PublisherOptJob) {
        this.eventManager.broadcast({ name: 'publisherListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackCampaignById(index: number, item: CampaignOptJob) {
        return item.id;
    }

    trackBlackListById(index: number, item: BlackListOptJob) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-publisher-opt-job-popup',
    template: ''
})
export class PublisherOptJobPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private publisherPopupService: PublisherOptJobPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.publisherPopupService
                    .open(PublisherOptJobDialogComponent as Component, params['id']);
            } else {
                this.publisherPopupService
                    .open(PublisherOptJobDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
